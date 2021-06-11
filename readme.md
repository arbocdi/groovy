### Groovy

* Groovy — это объектно-ориентированный язык.
* Groovy использует Java-подобный синтаксис
с динамической компиляцией в JVM байт-код.
* Groovy напрямую работает с Java кодом и библиотеками.

### Установка
* Скачать архив Groovy
* Добавить переменные окружения /etc/profile.d/groovy.sh
```bash
export GROOVY_HOME=~/path/to/groovy/
export PATH=$GROOVY_HOME/bin:$PATH
```

### Переменные

```java
def a = 1 // объявление "безтиповой" переменной, присвоение ей значения типа int
a = "String" /* так как мы не указали тип при объявлении этой переменной,
                то можно присваивать этой переменной значение другого типа */

int b = 2 // объявление переменной типа int, все простые типы в groovy
          // являются объектами и оборачиваются в соотв. wrappers
```

### Строки
* Java Strings — строки в одинарных кавычках
* Groovy Strings, известны как GStrings — в двойных кавычках; используя
${имя_переменной} можно "вставить" внутрь строки значение переменной
```Java
def javaString = 'java' // Java String
def groovyString = "Hello ${javaString}!" // GString
//Строку можно определить и так:
def string = /Hello World!/
```

### Списки

```java
def someList = [1,2,3,4]   // Создание списка
def emptyList = []         // Создание пустого списка

someList[0]                // Обращение к элементу по индексу

someList[5] = 6            // Добавление элемента в список
someList << 7 << 8         // Добавление элементов в конец списка
someList += [ 9, 10 ]      // "Приклеивание" списка

someList[1,3,5..7,9]       // Получение подсписка

for ( e in someList ) {
	println e          // Распечатываем все элементы списка someList
}
```

### Maps

```java
def someMap = [ 'a' : 1, 'b' : 2 ]   // Объявление
// Объявление пустого отображения
def emptyMap = [:]                   
def otherEmptyMap = [:] as HashMap

someMap['a']                         // Доступ к элементу
someMap.a                            // Доступ к элементу как к полю

someMap['a'] = 2                     // Изменение элемент
someMap.a = 2                        // Изменение элемента, как поля
```

### Условный оператор

```java
if (true){
	println("Good morning")
} else {
	println("Good evening")
}
```

### Range

```java
b = 1..5
a = "0123456789"
a[b]//12345
```

### Циклы
* Аналогично java, только есть объект range

```java
for (i in 0..9) {
    print i
}

for (int i = 0; i < 9; ++i) {
    print i
}
```

### Функции

* Функции всегда возвращают как результат последнее выражение.

```java
//не типизированная функция
def functionA(argA) {
    print ArgA
}
//типизированная
int functionA(int argA) {
    print ArgA
    return argA
}
//вызов
functionA(1)
functionA 1
```

### Closure

* Closure - это безымянная функция со свойствами объекта
```java
def c = {a, b ->
    //В замыканиях по умолчанию присутствует переменная it
    //и ссылается на первый параметр в замыкании:
    println "${it} ${b}"
}
//варианты вызова
c(1, 2)
c.call(1,2)
```
* If the closure is the last argument for a method
then we can put the closure outside the argument list.

### Классы

* по умолчанию класс имеет тип доступа public
* если у поля класса не указан модификатор доступа,то создается приватное поле
и публичные сеттеры\геттеры для него

```java
class Account {
    String name
    int value
    String password
}
//если конструктор явно не объявлен, то можно использовать конструктор
//принимающий map который содержит имена полей и их значение:
Account a = new Account(name:"arboc",value:1,password:"123")

println a.getName()
println a.name
```

* Можно в методы передавать map из параметров:

```java
def foo(Map args) {
	println "${args.name}: ${args.age}"
}
foo(name: 'Marie', age: 16)
```

### Регулярные выражения


```java
//creating Pattern object
Pattern p = ~/regex/
//creating matcher
Matcher m = p.matcher("string data")
//соответствует ли строка регулярному выражению?
boolean result = m.matches()
//short notation
Matcher m = "string data" =~/regex/
//even shorter
boolean result = "string data"==~/regex/
```

### Файлы

```java
File file = new File("C:/temp/test.txt")
//вывожу имя файла и размер
println "The file ${file.absolutePath} has ${file.length()} bytes"
//печатаю содержимое файла
println file.text
//читаю построчно
file.withReader { reader ->
         while ((line = reader.readLine())!=null) {
            println "${line}"
         }
}
//читаю файл как список строк
def lines = file.readLines()
//дописываю содержимое
file.write "This is the first line\n"
file << "This is the second line\n"
//перезаписываю содержимое
file.text = "Hello!"
//удаляю файлы по маске
new File("c:/temp").eachFileMatch(~/.*\.txt/) { file ->
         file.delete()
}
//list files and subdirs
new File("c:/temp").eachFile() { file->
         println file.getAbsolutePath()
}
//list files and subdirs recursively
new File("c:/temp").eachFileRecurse() { file->
         println file.getAbsolutePath()
}
```
