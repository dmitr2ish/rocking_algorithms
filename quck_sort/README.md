#Быстрая сортировка
- Сложность - O n * log n
- в худшем случае возможна квадратичная, всё зависит от выбора опоры

- выбрать опорный элемент
- разделить массив на два под массива
если опора середина
    - передавать без опоры начало массива до опоры, и конец массива без опоры
    - рекурсивно сортировать
если опора начало
    - передавать без опоры начало массива до опоры и конец массива с опорой
