# Tesztjegyzőkönyv-`Regisztráció`

Az alábbi tesztdokumentum az Étel projekthez tartozó 8.3.1 Regisztráció megvalósítása funkcióihoz készült. A regisztráció során a program ellenőrzi, hogy a megadott felhasználónévvel regisztrált-- már valaki korábban, hogy a jelszó és a jelszó megerősítése megegyezik-e és hogy az e-mail cím tartalma-e '@' karaktert.

## 1. Teszteljárások (TP)

### 1.1. Felhasználónév megadása funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Felhasználónév megadása funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást és próbáljunk meg beregisztrálni
    1. lépés: Az `felhasználónév` szövegbeviteli mezőbe írjunk be a `felhasználónév` értéket
    2. lépés: Az `jelszó` szövegbeviteli mezőbe írjunk be a `jelszó` értéket
    3. lépés: Az `jelszómásodszor` szövegbeviteli mezőbe írjunk be a `jelszómásodszor` értéket
    3. lépés: Az `email` szövegbeviteli mezőbe írjunk be a `email` értéket
    3. lépés: Nyomjuk meg az `regisztrál` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: regisztráció sikerességéről való információ

### 1.2. Jelszó ismételt megadása funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02
- Leírás: jelszó ismételt megadása funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást és próbáljunk meg beregisztrálni
    1. lépés: Az `felhasználónév` szövegbeviteli mezőbe írjunk be a `felhasználónév` értéket
    2. lépés: Az `jelszó` szövegbeviteli mezőbe írjunk be a `jelszó` értéket
    3. lépés: Az `jelszómásodszor` szövegbeviteli mezőbe írjunk be a `jelszómásodszor` értéket
    3. lépés: Az `email` szövegbeviteli mezőbe írjunk be a `email` értéket
    3. lépés: Nyomjuk meg az `regisztrál` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: regisztráció sikerességéről való információ

### 1.3. E-mail formátum ellenőrzése funkció tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-01, TC-02
- Leírás: e-mail formátum ellenőrzése funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást és próbáljunk meg beregisztrálni
    1. lépés: Az `felhasználónév` szövegbeviteli mezőbe írjunk be a `felhasználónév` értéket
    2. lépés: Az `jelszó` szövegbeviteli mezőbe írjunk be a `jelszó` értéket
    3. lépés: Az `jelszómásodszor` szövegbeviteli mezőbe írjunk be a `jelszómásodszor` értéket
    3. lépés: Az `email` szövegbeviteli mezőbe írjunk be a `email` értéket
    3. lépés: Nyomjuk meg az `regisztrál` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: regisztráció sikerességéről való információ

## 2. Tesztesetek (TC)

### 2.1. Felhasználónév megadása funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: felhasználónév megadásának ellenőrzése 
- Bemenet: `felhasználónév` = `teszt1` ; `jelszó` = `jelszó1`; `jelszómásodszor` = `jelszó1`; `email` = `teszt1@email.com`
- Művelet: nyomjuk meg az `regisztrál` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikeres regisztráció

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: felhasználónév megadásának ellenőrzése 
- Bemenet: `felhasználónév` = `teszt1` ; `jelszó` = `jelszó1`; `jelszómásodszor` = `jelszó1`; `email` = `teszt1@email.com`
- Művelet: nyomjuk meg az `regisztrál` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikertelen regisztráció - "Ez a felhasználónév már foglalt" (a korábbi tesztben használt adatokkal már létrejött egy felhasználó)

### 2.2. Jelszó ismételt megadása funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: jelszó ismételt megadása funkció tesztelése
- Bemenet: `felhasználónév` = `teszt2` ; `jelszó` = `jelszó2`; `jelszómásodszor` = `jelszó2`; `email` = `teszt2@email.com`
- Művelet: nyomjuk meg az `regisztrál` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikeres regisztráció

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: jelszó ismételt megadása funkció tesztelése
- Bemenet: `felhasználónév` = `teszt3` ; `jelszó` = `jelszó3`; `jelszómásodszor` = `helytelen`; `email` = `teszt3@email.com`
- Művelet: nyomjuk meg az `regisztrál` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikertelen regisztráció - "A jelszó és a jelszó megerősítése nem egyezik meg" (a jelszó és a jelszómasodszor mezők nem egyeznek meg)

### 2.3. E-mail formátum ellenőrzése funkció tesztesetei

#### 2.3.1. TC-01
- TP: TP-02
- Leírás: e-mail formátum ellenőrzése funkció tesztelése
- Bemenet: `felhasználónév` = `teszt4` ; `jelszó` = `jelszó4`; `jelszómásodszor` = `jelszó4`; `email` = `teszt4@email.com`
- Művelet: nyomjuk meg az `regisztrál` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikeres regisztráció

#### 2.3.2. TC-02
- TP: TP-02
- Leírás: e-mail formátum ellenőrzése funkció tesztelése
- Bemenet: `felhasználónév` = `teszt5` ; `jelszó` = `jelszó5`; `jelszómásodszor` = `jelszó5`; `email` = `teszt5email.com`
- Művelet: nyomjuk meg az `regisztrál` gombot 
- Elvárt kimenet: az eredmény mező tartalma: sikertelen regisztráció - "Az e-mail cím nem megfelelő formátumban lett megadva" (a megadott e-mail cím nem tartalmaz '@' karaktert)

## 3. Tesztriportok (TR)

### 3.1. Felhasználónév megadása funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    

### 3.2. Jelszó ismételt megadása funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
   

#### 3.2.1. TR-01 (TC-02)
- TP: TP-02

### 3.2. E-mail formátum ellenőrzése funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-03
   

#### 3.2.1. TR-01 (TC-02)
- TP: TP-03
    
