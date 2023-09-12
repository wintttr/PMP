# ИНСТРУКЦИЯЯЯЯЯЯ

Дабы упаковать данное чудо вводим (прямо из папки Calc):
```
javac -sourcepath src -d classes src\calc\Calc.java
jar cfe App.jar calc.Calc -C classes .
```

Для запуска вводим (оттуда же):
```
java -jar App.jar
```