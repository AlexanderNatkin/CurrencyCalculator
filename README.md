# CurrencyCalculator

Автор: Александр Наткин

Тестове задание Java SE Вариант 2:

Необходимо разработать калькулятор валют, работающий из консоли.
Калькулятор должен уметь работать с двумя валютами - доллар и рубль - и позволять
выполнять операции сложения и вычитания.
Складывать и вычитать можно только значения в одной валюте, должна быть
реализована операция конвертации из одной валюты в другую по курсу, который
задается во внешнем файле конфигурации. Необходимо реализовать поддержку не
только целых, но и дробных значений.
Значение в долларах обозначается символом $, расположенным перед числом
(например, $57,75), значение в рублях - символом “р”, расположенным после числа
(например, 57,75р).
Операция конвертации долларов в рубли - toRubles($57,75), рублей в доллары -
toDollars(57,75р). Разделитель целой и дробной части может быть любым на выбор
разработчика.
Пример консольного ввода: toDollars(737р + toRubles($85,4))
Для данного ввода вывод должен быть (при курсе 60 рублей за доллар, например):
5861р.

Описание программы:
ВНИМАНИЕ! Калькулятор будет работать только при наличии подключения к сети Интернет!
Калькулятор позволяет конвертировать доллары в рубли и обратно по актуальному курсу.
Имеется возможность подключить дополнительные валюты. Курсы валют загружаются с сайта ЦБ.
При запуске программы актуальный курс валюты выводится на экран, после чего можно начинать работать с программой.
Конвертация рублей в доллары осуществляется с помощью ввода команды: toDollars(492,62р),
символ "р" обязателен, может быть на латинице или кириллице.
Конвертация долларов в рубли производится командой: toRubles($100).
В обоих случаях разделитель целой и дробной части может быть либо точка, либо запятая, кому как удобнее.
Также калькулятор выполняет операции сложения и вычитания.
Сложение происходит с помощью команды: toDollars(737р + toRubles($85,4)), 
где сначала конвертируются доллары в рубли (toRubles($85,4)), а потом это значение складывается с 737р.
Вычитание реализовано только в случае, когда уменьшаемое больше вычитаемого, 
в противном случае получим сообщение: "Отрицательное значение".
Приятного пользования.

Вопросы, пожелания и предложения можно направлять на email natkin163@gmail.com


