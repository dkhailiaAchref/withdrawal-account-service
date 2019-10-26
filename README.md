<table>
<thead>
<tr>
<th align="center">Description</th>
</tr>
<br></br>
<tr><td align="left">This project usually is a simple combination of existing technologies. The following sample applications expose Api RestFull by (Spring-boot (data-jpa/web/test)
,junit, swagger2) to test (account management  withdrawal historized And Report Balance functionality) </td>
</tr>
</thead>
<tbody>
<tr>
<td colspan="2"><strong>Java</strong></td>
</tr>
<br></br>
<tr>
<td><b>REST Api with , spring-boot(web/test/data-jpa) , junit,mockito, swagger2, to test (account management  withdrawal historized And Report Balance  functionality)  </b>
</td>
</tr>
<tr>
<td><b>execute unit tests and acces to (ttps://localhost:8443/swagger-ui.html#) to test (account management  withdrawal historized And Report Balance  functionality)  </b>
<br></br>
 <br>* config with annotation ( endpoint REST)
 <br>* with swagger2 feature , for documentation api ,
 <br></br>
 * (aprés avoir  demarré le serveur embarqué de spring-web , par spring-boot:run )
 , vous pourrez tester les apis suivants :
  <br>* Api GET, get current account :</br>
   <a href="https://localhost:8443/accounts">https://localhost:8443/accounts </a>
   
   <br>* Swagger :</br> (offre une interface testant tous les Apis )
  <a href="https://localhost:8443/swagger-ui.html#">  https://localhost:8443/swagger-ui.html#</a>

 <br>* Api POST, (accounts):créditer  l'account courant par un montant</br>
  <br>* Api POST,testable sur postman en fournissant body json ( contenant le montant à créditer)</br>
 <a href="https://localhost:8443/withdrawAndReportBalance">https://localhost:8443/withdrawAndReportBalance </a>
    <br>* Api POST,testable sur swagger :</br>
<a href="  https://localhost:8443/swagger-ui.html#/accounts/addUsingPOST">  https://localhost:8443/swagger-ui.html#/accounts/addUsingPOST</a>


 <br>* Api POST, (withdrawAndReportBalance): effectuer un retrait account+rapport historique retraits+ solde restant </br>
    <br>* Api POST,testable sur postman en fournissant body json ( contenant le montant à retirer)</br>
<a href="https://localhost:8443/withdrawAndReportBalance">https://localhost:8443/withdrawAndReportBalance </a>
     <br>* Api POST, testable sur swagger :</br>
 <a href=" https://localhost:8443/swagger-ui.html#/accounts/withdrawAndReportBalanceUsingPOST"> https://localhost:8443/swagger-ui.html#/accounts/withdrawAndReportBalanceUsingPOST</a>


</td>
</tr>
</tbody>
</table>