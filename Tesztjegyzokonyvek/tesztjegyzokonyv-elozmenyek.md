# Tesztjegyzőkönyv-`Korábbi rendelések`

Az alábbi tesztdokumentum az Étel projekthez tartozó 8.3.9 Rendelési előzmények megtekintése funkcióhoz készült. Az alkalmazásban a felhasználó megtekintheti a korábbi rendeléseinek listáját, majd abból választva azok részleteit.

## 1. Teszteljárások (TP)

### 1.1. Előzmények megtekintése funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: Előzmények megtekintése funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk a felhasználó oldalára
    1. lépés: Nyomjuk meg az `előzmények` gombot 
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: minden korábbi rendelés megjelenítése

### 1.2. Korábbi rendelése részleteinek megtekintése funkció tesztelése 
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Korábbi rendelése részleteinek megtekintése funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk a felhasználó oldalára
    1. lépés: Nyomjuk meg az `előzmények` gombot 
    2. lépés: Válasszunk ki egy korábbi rendelést
    3. lépés: Nyomjuk meg a `részletek` gombot
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a rendelés adatainak megjelenítése

## 2. Tesztesetek (TC)

### 2.1. Előzmények megjelenítése tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: előzmények megtekintése funkció ellenőrzése 
- Bemenet: -
- Művelet: nyomjuk meg az `előzmények` gombot 
- Elvárt kimenet: minden korábbi rendelés kilistázása

### 2.2. Korábbi rendelés részleteinek megtekintése funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: korábbi rendelés adatainak megtekintése funkció ellenőrzése 
- Bemenet: rendelés kiválasztása
- Művelet: nyomjuk meg az `előzmények`, majd a `részletek` gombot 
- Elvárt kimenet: a kiválasztott rendelés adatainak megjelenítése

## 3. Tesztriportok (TR)

### 3.1. Előzmények megtekintése tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
  
### 3.2. Korábbi rendelés megtekintése funkció tesztriportjai  

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02

