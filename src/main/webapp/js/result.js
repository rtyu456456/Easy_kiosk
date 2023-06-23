	// 동작이 없으면 10초 후에 HC를 호출하는 js

    // 1.jsp 페이지가 로드되면 타이머를 시작합니다.
    document.addEventListener("DOMContentLoaded", function() {
      startTimer();
    });

    // 타이머를 시작하는 함수입니다.
    function startTimer() {
      // 남은 시간을 표시할 요소를 선택합니다.
      const countdownElement = document.getElementById("countdown");

      // 타이머 변수 초기화
      let timer = null;
      let remainingTime = 10; // 초기 값은 10입니다.
      countdownElement.textContent = remainingTime; // 초기 값을 표시합니다.(textContent는 텍스트를 추가해주는 프로퍼티)

      // 1초마다 남은 시간을 감소시키고 표시합니다.
      timer = setInterval(function() {
        remainingTime--;
        countdownElement.textContent = remainingTime;

        // 남은 시간이 0이 되면 HC.jsp로 이동합니다.
        if (remainingTime === 0) {
          clearInterval(timer);
          location.href = "HC";
        }
      }, 1000); // 1초 (1000ms)
      
      // 마우스 움직임 이벤트 리스너를 추가합니다.
      document.addEventListener("mousemove", resetTimer);
      
      // 키보드 입력 이벤트 리스너를 추가합니다.
      document.addEventListener("keypress", resetTimer);
      
      // 타이머를 초기화하는 함수입니다.
      function resetTimer() {
        remainingTime = 10; // 남은 시간을 다시 10으로 설정합니다.
        countdownElement.textContent = remainingTime;
      }
    }