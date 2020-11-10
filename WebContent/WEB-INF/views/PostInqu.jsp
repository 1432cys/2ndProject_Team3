<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 등록</title>
</head>
<body>
	<div data-v-0677f871="" id="info_container_3"
		class="detail_info-container">
		<div class="detail_info-heading">
			<h2 class="txt-heading">
				Q&amp;A <span class="count">(140)</span>
			</h2>
			<div class="wrap-utils">
				<!---->
				<a href="#" id="btn_write_qna" class="btn-write-qna">문의하기</a>
			</div>
		</div>
		<div class="detail_qna-container">
			<div class="wrap-qna-write" style="display: none;">
				<dl class="qna-write">
					<dt class="type">질문유형</dt>
					<dd class="type">
						<select id="ui-id-3" style="display: none;"><option
								value="">질문유형을 선택하세요.</option>
							<option value="2">상품 문의</option>
							<option value="3">교환/반품</option>
							<option value="4">불량/오배송</option>
							<option value="5">기타</option>
							<option value="6">배송 문의</option>
							<option value="7">하루배송</option>
							<option value="8">취소/변경</option></select><span tabindex="0"
							id="ui-id-3-button" role="combobox" aria-expanded="false"
							aria-autocomplete="list" aria-owns="ui-id-3-menu"
							aria-haspopup="true"
							class="ui-selectmenu-button Slct_customized-button ui-selectmenu-button-closed ui-corner-all ui-button ui-widget"
							aria-activedescendant="ui-id-20" aria-labelledby="ui-id-20"
							aria-disabled="false"><span
							class="ui-selectmenu-icon ui-icon ui-icon-triangle-1-s"></span><span
							class="ui-selectmenu-text">질문유형을 선택하세요.</span></span>
						<div id="select-box" style="position: relative; z-index: 1;">
							<div class="ui-selectmenu-menu Slct_customized-menu ui-front">
								<ul aria-hidden="true" aria-labelledby="ui-id-3-button"
									id="ui-id-3-menu" role="listbox" tabindex="0"
									class="ui-menu ui-corner-bottom ui-widget ui-widget-content"
									aria-activedescendant="ui-id-20" aria-disabled="false">
									<li class="ui-menu-item"><div id="ui-id-20" tabindex="-1"
											role="option" class="ui-menu-item-wrapper ui-state-active">질문유형을
											선택하세요.</div></li>
									<li class="ui-menu-item"><div id="ui-id-21" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">상품 문의</div></li>
									<li class="ui-menu-item"><div id="ui-id-22" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">교환/반품</div></li>
									<li class="ui-menu-item"><div id="ui-id-23" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">불량/오배송</div></li>
									<li class="ui-menu-item"><div id="ui-id-24" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">기타</div></li>
									<li class="ui-menu-item"><div id="ui-id-25" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">배송 문의</div></li>
									<li class="ui-menu-item"><div id="ui-id-26" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">하루배송</div></li>
									<li class="ui-menu-item"><div id="ui-id-27" tabindex="-1"
											role="option" class="ui-menu-item-wrapper">취소/변경</div></li>
								</ul>
							</div>
						</div>
					</dd>
					<dt class="conts">내용</dt>
					<dd class="conts">
						<textarea rows="3" cols="5" placeholder="내용을 입력해 주세요."
							class="txtarea-conts"></textarea>
					</dd>
					<dt class="private">공개여부</dt>
					<dd class="private">
						<a href="#" class="chk-private">비공개</a>
					</dd>
				</dl>
				<div class="wrap-btn">
					<button type="button" id="qna_write_cancel" class="btn-cancle">취소하기</button>
					<button type="submit" class="btn-submit">등록하기</button>
				</div>
			</div>
			<div class="wrap-qna-list">
				<table class="qna-list">
					<colgroup>
						<col style="width: 164px;">
						<col style="width: 152px;">
						<col>
						<col style="width: 162px;">
						<col style="width: 162px;">
					</colgroup>
					<thead>
						<tr>
							<th>분류</th>
							<th>처리상태</th>
							<th>내용</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<!--fragment#45608f8752#head-->
						<tr fragment="45608f8752">
							<td class="type al-l">배송 문의</td>
							<td class="state"><span class="ico-state">답변대기</span></td>
							<td class="contents al-l"><div class="wrap">
									<a href="#" class="conts secret">비밀글입니다.</a>
									<!---->
									<div class="wrap-detail">
										<p class="conts secret">비밀글입니다.</p>
										<!---->
										<!---->
										<!---->
									</div>
								</div></td>
							<td class="writer">wj0***</td>
							<td class="date">2020.11.09</td>
						</tr>
						<tr fragment="45608f8752">
							<td class="type al-l">배송 문의</td>
							<td class="state"><span class="ico-state answer">답변완료</span></td>
							<td class="contents al-l"><div class="wrap">
									<a href="#" class="conts secret">비밀글입니다.</a>
									<!---->
									<div class="wrap-detail">
										<p class="conts secret">비밀글입니다.</p>
										<div class="answer">
											<strong class="lbl">답변</strong>
											<p class="conts secret">비밀글입니다.</p>
										</div>
										<span class="writer">더뮤즈</span> <span class="date">2020.11.09</span>
									</div>
								</div></td>
							<td class="writer">yun***</td>
							<td class="date">2020.11.09</td>
						</tr>
						<tr fragment="45608f8752">
							<td class="type al-l">교환/반품</td>
							<td class="state"><span class="ico-state answer">답변완료</span></td>
							<td class="contents al-l"><div class="wrap">
									<a href="#" class="conts secret">비밀글입니다.</a>
									<!---->
									<div class="wrap-detail">
										<p class="conts secret">비밀글입니다.</p>
										<div class="answer">
											<strong class="lbl">답변</strong>
											<p class="conts secret">비밀글입니다.</p>
										</div>
										<span class="writer">더뮤즈</span> <span class="date">2020.11.09</span>
									</div>
								</div></td>
							<td class="writer">quf***</td>
							<td class="date">2020.11.09</td>
						</tr>
						<tr fragment="45608f8752">
							<td class="type al-l">상품 문의</td>
							<td class="state"><span class="ico-state">답변대기</span></td>
							<td class="contents al-l"><div class="wrap">
									<a href="#" class="conts secret">비밀글입니다.</a>
									<!---->
									<div class="wrap-detail">
										<p class="conts secret">비밀글입니다.</p>
										<!---->
										<!---->
										<!---->
									</div>
								</div></td>
							<td class="writer">jun***</td>
							<td class="date">2020.11.08</td>
						</tr>
						<tr fragment="45608f8752">
							<td class="type al-l">교환/반품</td>
							<td class="state"><span class="ico-state answer">답변완료</span></td>
							<td class="contents al-l"><div class="wrap">
									<a href="#" class="conts secret">비밀글입니다.</a>
									<!---->
									<div class="wrap-detail">
										<p class="conts secret">비밀글입니다.</p>
										<div class="answer">
											<strong class="lbl">답변</strong>
											<p class="conts secret">비밀글입니다.</p>
										</div>
										<span class="writer">더뮤즈</span> <span class="date">2020.11.06</span>
									</div>
								</div></td>
							<td class="writer">tng***</td>
							<td class="date">2020.11.06</td>
						</tr>
						<!--fragment#45608f8752#tail-->
					</tbody>
				</table>
			</div>
			<div class="wrap-paging">
				<div class="Nav_paging padtop40">
					<a href="#" class="first disabled"><span class="txt">시작
							페이지</span></a> <a href="#" class="prev disabled"><span class="txt">이전
							페이지</span></a> <a href="#" class="page active">1</a><a href="#" class="page">2</a><a
						href="#" class="page">3</a><a href="#" class="page">4</a><a
						href="#" class="page">5</a> <a href="#" class="next"><span
						class="txt">다음 페이지</span></a> <a href="#" class="last"><span
						class="txt">끝 페이지</span></a>
				</div>
				<!---->
			</div>
		</div>
	</div>

</body>
</html>