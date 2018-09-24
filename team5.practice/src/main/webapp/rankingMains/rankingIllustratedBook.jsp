<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   


<div class="menu" >
    <ul>
      <li class="select"><a href="#">어종별 대물 랭킹</a></li>
      <li class="unselect"><a href="#">전체 랭킹</a></li>
      <li class="unselect"><a href="#">도감 수집도 랭킹</a></li>
    </ul>
 </div>

 <br>
  <div class="menu" >
     <ul>
      <li class="select"><a href="#">전체</a></li>
      <li class="unselect"><a href="#">바다</a></li>
      <li class="unselect"><a href="#">민물</a></li>
    </ul>
  </div>


<br>



 <table>
      <thead>
        <tr>
          <th colspan="5">길이</th>
        </tr>
      <thead>
      <tbody>
      <%for(int i = 1; i<20;i++) {%>
        <tr>
          <td>1위</td>
          <td>해동왕 (howon1042)</td>
          <td>수집도 <progress value="50" max="100"></progress> 42%</td>
          <td>240종</td>
        </tr>
        <%}%>
      </tbody>
    </table>