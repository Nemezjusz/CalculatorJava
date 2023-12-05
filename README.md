# Kalkulator Java

Implementacja kalkulatora oparta na następujących zasadach:

|           |operator | cyfra | znak = | Clear |
------------|---------|-------|--------|-------|
operator    | a       | b     | c      | d     |
cyfra       | e       | f     | g      | d     |
znak =      | h       | i     | j      | d     |
Clear       | d       | d     | d      | d     |  


a)  operator - operator:   nowy operator nadpisuje stary - nie wpływa to na zmianę wartości argumentów;

b)  operator - cyfra:   nowa cyfra będzie wstawiana jako składowa wartość drugiego argumentu operatora;

c)  operator - znak =  wyliczamy wartość wyrażenia jako:

[wartość pierwszego argumentu]  <operator>  [wartość pierwszego argumentu]

d)  czyścimy wszystkie wartości operatorów - przywracamy stan z początku pracy kalkulatora;

e)  ustawiamy argument pierwszy, zapisujemy operator;

f)  kontynuujemy pobieranie wartości dla tego samego argumentu - kolejne cyfry tej samej liczby;

g)  jeśli był zapisany operator to wykonujemy działanie i zapisujemy wynik;

h)  dotychczasowy wynik staje się  pierwszym argumentem, zapsujemy operator.

i)  czyścimy wcześniejsze ustawienia, zaczynamy od początku obliczenia, cyfra rozpoczyna pobieranie składowych liczby pierwszego argumentu.

j)  potwarzamy ostatnie działanie jeśli ono było, jeśli nie, to bez zmian.

Więcej szczegółów i przykładów działania można znaleść na:


## GUI
<img width="322" alt="Screenshot 2023-12-05 at 14 37 23" src="https://github.com/Nemezjusz/KalkulatorJava/assets/50834734/8a4c1769-1f24-484c-9527-477777d1f98f">
