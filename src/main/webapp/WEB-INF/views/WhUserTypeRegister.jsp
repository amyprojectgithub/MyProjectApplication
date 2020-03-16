<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" style="color: blue">
<h3 style="text-align: center">::::Welcome To WhUserType Register Page::::</h3>
<form:form action="save" method="POST" modelAttribute="whUserType">
<pre>
 User Type:: <form:radiobutton path="whUserType" value="Vender"/>Vender&nbsp;<form:radiobutton path="whUserType" value="Customer"/>Customer
 User Code::<form:input path="whUserCode"/>     
 UserFor:: <form:input path="userFor"/>       
 User Mail::<form:input path="whUserMail"/>
 User Contact::<form:input path="whUserContact"/>     
 User Id Type::<form:select path="whUserIdType">
                         <form:option value="">--select--</form:option>
                         <form:option value="CARD"> CARD</form:option>
                         <form:option value="AADHAR">AADHAR</form:option>
                         <form:option value="VOTERID">VOTERID</form:option>
                         <form:option value="OTHER">OTHER</form:option>
                       </form:select>
 If Other::<form:input path="whUserOtherIdType"/>
 Id Number::<form:input path="whUserIdNum"/>           
 <input type="submit" value="CREATE USER"/>           
</pre>
</form:form>
${message}
</body>
 <!--  <SCRIPT LANGUAGE="JavaScript">
      function testResults (form) {
      var TestVar1 = form.whUserType[0].checked;
      var TestVar2 = form.whUserType[1].checked;
        if (TestVar1 == true) {
          form.userFor.value = "sale";
        } else if (TestVar2 == true){
          form.userFor.value = "purchase";
        } else if (TestVar1 == false && TestVar2 == false) {
          form.userFor.value = "";
        }
      }
</SCRIPT> -->
</html>