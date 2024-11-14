# Tesztjegyzőkönyv-`Kosár`

Az alábbi tesztdokumentum az Étel projekthez tartozó 8.3.7 Kosár funkcióhoz készült. Az alkalmazásban az ételeket a kosárba lehet helyezni, több étel is lehet egyszerre a kosárba és el lehet távolítani elemeket a kosárból.

## 1. Teszteljárások (TP)

### 1.1. Étel hozzáadása funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: Étel hozzáadása a kosárhoz funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk egy étterem oldalára
    1. lépés: Válasszunk ki egy ételt
    2. lépés: Nyomjuk meg a `kosárba helyez` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: az étel a kosárba kerül

### 1.2. Több étel hozzáadása funkció tesztelése 
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Több étel hozzáadása a kosárhoz funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és navigáljunk egy étterem oldalára
    1. lépés: Válasszunk ki egy ételt
    2. lépés: Nyomjuk meg a `kosárba helyez` gombot
    3. lépés: Válasszunk ki egy második ételt
    4. lépés: Nyomjuk meg a `kosárba helyez` gombot
    5. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: mindkét étel a kosárba kerül

### 1.3. Étel törlése funkció tesztelése 
- Azonosító: TP-03
- Tesztesetek: TC-01, TC-02
- Leírás: Étel törlése a kosárból funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, jelentkezzünk be és helyezzünk `darabszám` elemet a kosárba
    1. lépés: Navigáljunk a kosár oldalára
    2. lépés: Válasszunk ki egy ételt
    3. lépés: Nyomjuk meg az `étel eltávolítása a kosárból` gombot
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: A kiválasztott elem eltűnik a kosárból, csak a kiválasztott elem tűnik el

## 2. Tesztesetek (TC)

### 2.1. Étel hozzáadása funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: étel hozzáadása a kosárhoz funkció ellenőrzése 
- Bemenet: étel kiválasztása
- Művelet: nyomjuk meg a `kosárba helyez` gombot 
- Elvárt kimenet: az étel megjelenik a kosárban

### 2.2. Több étel hozzáadása funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: több étel hozzáadása a kosárhoz funkció ellenőrzése 
- Bemenet: mindkét étel kiválasztása
- Művelet: nyomjuk meg kétszer a `kosárba helyez` gombot 
- Elvárt kimenet: mindkét étel megjelenik a kosárban

### 2.3. Étel törlése funkció tesztesetei

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: étel eltávolítása a kosárból, amikor csak egy elemet tartalmaz funkció ellenőrzése 
- Bemenet: `darabszám` = 1, étel kiválasztása
- Művelet: nyomjuk meg az `étel eltávolítása a kosárból` gombot 
- Elvárt kimenet: a kiválasztott étel eltűnik a kosárból

#### 2.3.2. TC-02
- TP: TP-03
- Leírás: étel eltávolítása a kosárból, amikor több elemet is tartalmaz funkció ellenőrzése 
- Bemenet: `darabszám` = 3, étel kiválasztása
- Művelet: nyomjuk meg a `étel eltávolítása a kosárból` gombot 
- Elvárt kimenet: a kiválasztott étel eltűnik a kosárból, csak a kiválasztott étel tűnik el

## 3. Tesztriportok (TR)

### 3.1. Étel hozzáadása funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
  
### 3.2. Több étel hozzáadása funkció tesztriportjai  

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    
### 3.3. Étel etávolítása funkció tesztriportjai

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03

#### 3.3.2. TR-02 (TC-02)
- TP: TP-03
