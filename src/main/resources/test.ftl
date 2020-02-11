<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${name}!</title>
</head>
<body>

<p>--------------------</p>
<#assign kiss = "Clit">
His name is ${kiss}.
<p>--------------------</p>
<#assign value = 4>

<#if value < 0 >
  The number is negative
<#elseif value == 0>
  The number is zero
<#else>
  The number is positive
</#if>

<p>--------------------</p><hr>

<#assign colours = ["red", "green", "blue", "yellow"]>

<#list colours as col>
    ${col}
</#list>

<p>--------------------</p>
<#assign items = {"pens": 3, "cups": 2, "tables": 1}>

<#list items?values as v>
    ${v}
</#list>

<#list items?keys as k>
    ${k}
</#list>

<p>--------------------</p>
<#assign value="\t\tweather\n\n">

<#compress>
    ${value}
        Today is a wonderful day.
   1 2   3       4     5
</#compress>

<p>--------------------</p>
<h2>Hello ${name}! ${pedros}</h2>

<div>
<#list books as book>
    ${book.name}: ${book.price}
</#list>
</div>

</body>
</html>
