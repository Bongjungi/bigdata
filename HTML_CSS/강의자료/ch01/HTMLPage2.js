/* 동적인 부분(DB연동X) = 자바스크립트(함수형, 인터프리터 언어)*/
name = prompt("이름이 뭐니?", "홍길동");
document.write(name + '~ Welcome<br>');
name = prompt('ㅋㅋ', 'ㅋㅋ');
document.write(name + 'ㅠㅠ<br>');
function chk() {
    if (frm.tel.value.length < 4) {
        alert("전화번호는 4자리 이상을 입력하세요.");
        return false; //submit 이벤트가 제한.
    }
}
