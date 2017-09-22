<jsp:useBean id="calc" class="da2.alv.u1.Calculadora"></jsp:useBean>
<jsp:setProperty property="*" name="calc"/>
<strong> El resultado es:
<jsp:getProperty property="resultado" name="calc"/>
</strong> 