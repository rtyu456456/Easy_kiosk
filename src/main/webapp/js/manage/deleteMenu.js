function delMenu(m_no){
	let ok = confirm("정말 삭제하시겠습니까?");
	if(ok){
		location.href='DeleteMenuC?m_no=' + m_no;
	}
	
}

