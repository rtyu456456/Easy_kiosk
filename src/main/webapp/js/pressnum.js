// 핸드폰 번호를 누를 수 있게 해주는 js

function validateForm() { // 확인 버튼으로 값 제출시 호출됨
            var firstInput = document.getElementById("firstInput").value;
            var secondInput = document.getElementById("secondInput").value;

            // 입력값이 4자리인지 확인
            if (firstInput.length !== 4 || secondInput.length !== 4) {
                swal ( "오류" ,  "전화번호를 8자리 입력해주세요" ,  "error" ) // alert창
                clearNumber();
                return false;
            }

            // 첫 번째 input에 4자리까지만 입력 가능
            if (firstInput.length >= 4) {
                document.getElementById("secondInput").focus();
            }

            return true;
        }
       
function clearNumber() { // input의 모든 값을 전부 삭제하는 기능
	document.getElementById("firstInput").value = "";
    document.getElementById("secondInput").value = "";
}
 
function addNumberToInput(number) { // 버튼을 누르면 1번input부터 2번 input까지 입력되는 기능
            var firstInput = document.getElementById("firstInput"); // 첫 번째 input안에 들어있는 값
            var secondInput = document.getElementById("secondInput"); // 두 번째 input안에 들어있는 값

            // 첫 번째 input이 비어있을 때
            if (firstInput.value.length < 4) {
                firstInput.value += number;
            }
            // 첫 번째 input에 4자리 숫자가 입력되어 있을 때
            else if (secondInput.value.length < 4) {
                secondInput.value += number;
            }
        }

function deleteLastDigit() { // 오른쪽부터 하나씩 지우는 기능
            var firstInput = document.getElementById("firstInput");
            var secondInput = document.getElementById("secondInput");

            if (secondInput.value.length > 0) { // secondInput에 값이 있을 경우
                secondInput.value = secondInput.value.slice(0, -1); // 맨 끝에서 부터 하나씩 삭제
            } else if (firstInput.value.length > 0) { // secondInput에 값이 없을 경우
                firstInput.value = firstInput.value.slice(0, -1);
            }
        }

