<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
      .grid-container {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 10px;
      }

      .grid-item {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
        cursor: pointer;
      }
    </style>
  </head>
<body>
    <h1>간단한 모달 창 예제</h1>

    <div class="grid-container">
      <div class="grid-item" onclick="openModal('imgs/coffee.png')">메뉴 1</div>
      <div class="grid-item" onclick="openModal('menu2.jpg')">메뉴 2</div>
      <div class="grid-item" onclick="openModal('menu3.jpg')">메뉴 3</div>
    </div>

    <dialog id="myModal" class="modal">
      <button id="close-btn">X</button>
      <img id="modalImage" src="#" alt="메뉴 이미지" />
    </dialog>
  <script>
    const modal = document.getElementById("myModal");
    const modalImage = document.getElementById("modalImage");
    const closeBtn = document.getElementById("close-btn");

    function openModal(imageSrc) {
      modalImage.src = imageSrc;
      modal.showModal();
    }

    closeBtn.addEventListener("click", closeModal);

    function closeModal() {
      modal.close();
    }
  </script>
</body>
</html>