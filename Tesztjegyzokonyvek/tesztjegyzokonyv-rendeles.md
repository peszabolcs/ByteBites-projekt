# Tesztjegyzőkönyv-`Rendelés`

Az alábbi tesztdokumentum az Étel projekthez tartozó 8.3.8 Rendelés funkcióhoz készült. Az alkalmazásban a felhasználó a kosár tartalmát meg tudja rendeli, a rendelési folyamatban meg kell adnia a címét.

## 1. Teszteljárások (TP)

### 1.1. Kosár megrendelése funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Kosár megrendelése funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és vegyünk fel a kosárba `darabszám` ételt
    1. lépés: Nyomjuk meg az `rendelés` gombot 
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: rendelés sikerességről való információ, átirányítás a fizetés oldalára

### 1.2. Cím megadása funkció tesztelése 
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Korábbi rendelése részleteinek megtekintése funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk a fizetés oldalára
    1. lépés: Az `irányítószám` mezőbe írjuk az `irányítószám` értéket
    2. lépés: A `város` mezőbe írjuk a `város` értéket
    3. lépés: Az `utca` mezőbe írjuk az `utca` értéket
    3. lépés: A `házszám` mezőbe írjuk a `házszám` értéket
    5. lépés: Nyomjuk meg a `rendelés befejezése` gombot
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a rendelés lebonyolításának megkezdése

## 2. Tesztesetek (TC)

### 2.1. Kosár megrendelése funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: kosár megrendelése amikor több elem van a kosárban ellenőrzése 
- Bemenet: a `darabszám` = 3
- Művelet: nyomjuk meg az `rendelés` gombot 
- Elvárt kimenet: átirányítás a fizetés oldalára

#### 2.1.1. TC-02
- TP: TP-01
- Leírás: kosár megrendelése amikor nincs elem a kosárban ellenőrzése 
- Bemenet: a `darabszám` = 0
- Művelet: nyomjuk meg az `rendelés` gombot 
- Elvárt kimenet: sikertelen rendelés - "A kosár üres"

### 2.2. Cím megadása funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: cím megadása funkció ellenőrzése helyes adatokkal ellenőrzése 
- Bemenet: az `irányítószám` mezőbe írjuk az `1234` értéket, a `város` mezőbe a `Szeged` értéket, az `utca` mezőbe az `Alma` értéket, a `házszám` mezőbe a `6` értéket
- Művelet: nyomjuk meg az `rendelés befejezése` gombot 
- Elvárt kimenet: sikeres rendelés

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: cím megadása funkció ellenőrzése helytelen irányítószámmal ellenőrzése 
- Bemenet: az `irányítószám` mezőbe írjuk az `egér` értéket, a `város` mezőbe a `Szeged` értéket, az `utca` mezőbe az `Alma` értéket, a `házszám` mezőbe a `6` értéket
- Művelet: nyomjuk meg az `rendelés befejezése` gombot 
- Elvárt kimenet: sikertelen rendelés - "Helytelen irányítószám" (az irányítószám nem megfelelő formátumban van megadva)

#### 2.2.3. TC-03
- TP: TP-02
- Leírás: cím megadása funkció ellenőrzése helytelen várossal ellenőrzése 
- Bemenet: az `irányítószám` mezőbe írjuk az `1234` értéket, a `város` mezőbe a `23` értéket, az `utca` mezőbe az `Alma` értéket, a `házszám` mezőbe a `6` értéket
- Művelet: nyomjuk meg az `rendelés befejezése` gombot 
- Elvárt kimenet: sikertelen rendelés - "Helytelen város" (a város nem megfelelő formátumban van megadva)

#### 2.2.3. TC-04
- TP: TP-02
- Leírás: cím megadása funkció ellenőrzése hiányos várossal ellenőrzése 
- Bemenet: az `irányítószám` mezőbe írjuk az `1234` értéket, a `város` mezőbe a `-` értéket, az `utca` mezőbe az `Alma` értéket, a `házszám` mezőbe a `6` értéket
- Művelet: nyomjuk meg az `rendelés befejezése` gombot 
- Elvárt kimenet: sikertelen rendelés - "Helytelen város" (a város nincs megadva)

#### 2.2.3. TC-05
- TP: TP-02
- Leírás: cím megadása funkció ellenőrzése helytelen utcával ellenőrzése 
- Bemenet: az `irányítószám` mezőbe írjuk az `1234` értéket, a `város` mezőbe a `Szeged` értéket, az `utca` mezőbe az `!%` értéket, a `házszám` mezőbe a `6` értéket
- Művelet: nyomjuk meg az `rendelés befejezése` gombot 
- Elvárt kimenet: sikertelen rendelés - "Helytelen utca" (az utca nem megfelelő formátumban van megadva)

#### 2.2.3. TC-06
- TP: TP-02
- Leírás: cím megadása funkció ellenőrzése helytelen utcával ellenőrzése 
- Bemenet: az `irányítószám` mezőbe írjuk az `1234` értéket, a `város` mezőbe a `Szeged` értéket, az `utca` mezőbe az `-` értéket, a `házszám` mezőbe a `6` értéket
- Művelet: nyomjuk meg az `rendelés befejezése` gombot 
- Elvárt kimenet: sikertelen rendelés - "Helytelen utca" (az utca nincs megadva)

## 3. Tesztriportok (TR)

### 3.1. Előzmények megtekintése tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
  
### 3.2. Korábbi rendelés megtekintése funkció tesztriportjai  

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02

#### 3.2.2. TR-02 (TC-02)
- TP: TP-02

#### 3.2.3. TR-03 (TC-03)
- TP: TP-02

#### 3.2.4. TR-04 (TC-04)
- TP: TP-02

#### 3.2.5. TR-05 (TC-05)
- TP: TP-02

#### 3.2.6. TR-06 (TC-06)
- TP: TP-02



