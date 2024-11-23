# Tesztjegyzőkönyv-`Éttermek keresése`

Az alábbi tesztdokumentum az Étel projekthez tartozó 8.3.3 Éttermek keresése helyszín apján és 8.3.4 Éttermek keresése egyéb szűrők alapján funkcióikhoz készült. Az alkalmazásban lehet keresni  éttermek között az alapján, hogy azok melyik városban vannak, illetve van-e lehetőség speciális étkezésre (vegán, vegetáriánus, glutén mentes kritériumok).

## 1. Teszteljárások (TP)

### 1.1. Étterem keresése funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: Étterem keresése város alapján funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk a keresés funkcióhoz
    1. lépés: A `város` mezőbe válasszuk ki a `város` értéket
    2. lépés: A `speciális` mezőbe válasszuk ki a `speciális` értéket
    3. lépés: Nyomjuk meg a `keresés` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: minden étterem megjelenítése

### 1.1. Étterem keresése város alapján funkció tesztelése 
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Étterem keresése város alapján funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk a keresés funkcióhoz
    1. lépés: A `város` mezőbe válasszuk ki a `város` értéket
    2. lépés: A `speciális` mezőbe válasszuk ki a `speciális` értéket
    3. lépés: Nyomjuk meg a `keresés` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a szűrőknek megfelelő éttermek megjelenítése

### 1.2. Étterem keresése speciális étkezés alapján funkció tesztelése 
- Azonosító: TP-03
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Étterem keresése speciális étkezés alapján funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk a keresés funkcióhoz
    1. lépés: A `város` mezőbe válasszuk ki a `város` értéket
    2. lépés: A `speciális` mezőbe válasszuk ki a `speciális` értéket
    3. lépés: Nyomjuk meg a `keresés` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a szűrőknek megfelelő éttermek megjelenítése

## 2. Tesztesetek (TC)

### 2.1. Étterem keresése funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: étterem keresése város alapján funkció ellenőrzése 
- Bemenet: `város` = '-', `speciális` = '-'
- Művelet: nyomjuk meg a `keresés` gombot 
- Elvárt kimenet: a program megjelenít minden éttermet

### 2.2. Étterem keresése város alapján funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: étterem keresése város alapján funkció ellenőrzése 
- Bemenet: `város` = 'Szeged', `speciális` = '-'
- Művelet: nyomjuk meg a `keresés` gombot 
- Elvárt kimenet: a program megjelenít minden Szeged területén található éttermet, a program csak Szeged területén található éttermeket jelenít meg

### 2.3. Étterem keresése speciális étkezés alapján funkció tesztesetei

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: étterem keresése speciális étkezés (vegán) alapján funkció ellenőrzése 
- Bemenet: `város` = '-', `speciális` = 'vegán'
- Művelet: nyomjuk meg a `keresés` gombot 
- Elvárt kimenet: a program megjelenít minden vegán ételeket felszolgáló éttermet, a program csak vegán opcióval rendelkező éttermeket jelenít meg

#### 2.3.2. TC-02
- TP: TP-03
- Leírás: étterem keresése speciális étkezés (vegetáriánus) alapján funkció ellenőrzése 
- Bemenet: `város` = 'Szeged', `speciális` = 'vegetáriánus'
- Művelet: nyomjuk meg a `keresés` gombot 
- Elvárt kimenet: a program megjelenít minden Szeged területén található, vegetáriánus ételt kínáló éttermet, a program csak Szeged területén található és csak vegetáriánus opciót kínáló éttermeket jelenít meg

#### 2.3.3. TC-03
- TP: TP-03
- Leírás: Étterem keresése speciális étkezés (gluténmentes) alapján funkció ellenőrzése 
- Bemenet: `város` = '-', `speciális` = 'gluténmentes'
- Művelet: nyomjuk meg a `keresés` gombot 
- Elvárt kimenet: a program megjelenít minden gluténmentes ételeket felszolgáló éttermet, a program csak gluténmentes opcióval rendelkező éttermeket jelenít meg


## 3. Tesztriportok (TR)

### 3.1. Étterem keresése funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
  
### 3.1. Étterem keresése város alapján funkció tesztriportjai  

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    
### 3.1. Étterem keresése speciális étkezés alapján funkció tesztriportjai

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03

#### 3.3.1. TR-02 (TC-02)
- TP: TP-03

#### 3.3.1. TR-03 (TC-03)
- TP: TP-03
