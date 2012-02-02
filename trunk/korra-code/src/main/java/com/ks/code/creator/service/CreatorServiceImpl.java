package com.ks.code.creator.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korrasoft.framework.core.web.paging.Paging;
import com.ks.code.account.domain.Account;
import com.ks.code.core.writer.CodeTemplate;
import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.domain.aggregate.CodeFile;
import com.ks.code.creator.service.support.ShortUrlUtil;

@Service
@Transactional
public class CreatorServiceImpl implements CreatorService {

	@Autowired protected Paging paging;
	@Autowired protected CodeTemplate codeTemplate;
	
	/**
	 * under code 
	 * auto-created by max-service addons
	 */
	@Override
	public CodeCreator save(CodeCreator codecreator) {
		codecreator.setWriteDate(new Date());
		codecreator.persist(); //1) 기본값 저장 후
		codecreator.setShortUrl(ShortUrlUtil.base48Encode(codecreator.getId()));// 2) shorturl 생성후
		codecreator = codeTemplate.write(codecreator);// 3) 코드를 생성한다.
		codecreator.merge();
		return codecreator;
	}
		
	@Override
	public CodeCreator update(CodeCreator codecreator) {
		codecreator.merge();
		return codecreator;
	}	

	@Override
	public void remove(CodeCreator codecreator) {
		// file delete
		List<CodeFile> codeFiles = codecreator.getCodeFiles();
		for (CodeFile codeFile : codeFiles) {
			File file = new File(codeFile.getFileDir());
			if(file.exists()){
				file.delete();
			}
		}
		codecreator.remove(); //cascade all
	}

	@Override
	public CreatorServiceResult findById(Long id) {
		return new CreatorServiceResult(CodeCreator.findCodeCreator(id));
	}

	@Override
	public CreatorServiceResult findCodeCreatorEntries(Account account, int currentPage, int startNumber) {
		Long count = CodeCreator.countCodeCreators();
		return new CreatorServiceResult(CodeCreator.findByPages(account, startNumber, paging.getRowScale()),count, pageProcessor(currentPage, count, "", "", ""));
	}
	protected String pageProcessor(int currentPage, Long count, String pageUrl, String keyField, String keyWord) {
		paging.setPage(count, (long)currentPage, pageUrl, "keyField="+keyField+"&keyWord="+keyWord);
		return paging.getPage();
	}	
}
