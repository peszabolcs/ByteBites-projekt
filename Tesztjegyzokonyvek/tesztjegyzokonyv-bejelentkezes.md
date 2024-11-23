# Tesztjegyzőkönyv-`Bejelenkezés`

Az alábbi tesztdokumentum az Étel projekthez tartozó 8.3.2 Bejelentkezés megvalósítása funkcióihoz készült. A bejelentkezés során a program ellenőrzi, hogy a megadott felhasználónév és jelszó egyazon, létező felhasználóhoz tartozik-e.

## 1. Teszteljárások (TP)

### 1.1. Bejelentkezés funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Bejelentkezés funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást és próbáljunk meg bejelentkezni
    1. lépés: Az `felhasználónév` szövegbeviteli mezőbe írjunk be a `felhasználónév` értéket
    2. lépés: Az `jelszó` szövegbeviteli mezőbe írjunk be a `jelszó` értéket
    3. lépés: Nyomjuk meg a `bejelentkezés` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: bejelentkezés sikerességéről való információ

## 2. Tesztesetek (TC)

### 2.1. Bejelentkezés funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: bejelentkezés funkció ellenőrzése 
- Bemenet: a korábbi tesztek és példa adatbázis alapján adjunk meg egy már regisztrált felhasználónevet a helyes jelszóval párosítva
- Művelet: nyomjuk meg a `bejelentkezés` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikeres bejelentkezés

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: bejelentkezés funkció ellenőrzése 
- Bemenet: a korábbi tesztek és példaadatbázis alapján adjunk meg egy már regisztrált felhasználónevet egy helytelen jelszóval párosítva
- Művelet: nyomjuk meg a `bejelentkezés` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikertelen bejelentkezés - "Hibás jelszó"

#### 2.1.2. TC-03
- TP: TP-01
- Leírás: bejelentkezés funkció ellenőrzése 
- Bemenet: a korábbi tesztek és példaadatbázis alapján adjunk meg egy még nem regisztrált felhasználónevet egy tetszőleges jelszóval párosítva
- Művelet: nyomjuk meg a `bejelentkezés` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikertelen bejelentkezés - "Hibás felhasználónév"


## 3. Tesztriportok (TR)

### 3.1. Bejelentkezés funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    

#### 3.1.2. TR-03 (TC-03)
- TP: TP-01
