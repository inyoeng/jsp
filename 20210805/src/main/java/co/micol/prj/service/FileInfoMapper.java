package co.micol.prj.service;

import java.util.List;

import co.micol.prj.img.vo.FileInformationVO;

public interface FileInfoMapper {
	List<FileInformationVO> fileSelectList();
	FileInformationVO fileSelect(int key);
	int fileInsert(FileInformationVO vo);
	int fileUpdate(FileInformationVO vo);
	int fileDelete(int key);
}
