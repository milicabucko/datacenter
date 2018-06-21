insert into stavka_osiguranja (id, kategorija, naziv)
values (1, 'sport', 'Fudbal');
insert into stavka_osiguranja (id, kategorija, naziv)
values (2, 'sport', 'Kosarka');
insert into stavka_osiguranja (id, kategorija, naziv)
values (3, 'sport', 'Odbojka');

insert into stavka_osiguranja (id, kategorija, naziv)
values (4, 'region', 'Evropa');
insert into stavka_osiguranja (id, kategorija, naziv)
values (5, 'region', 'Azija');
insert into stavka_osiguranja (id, kategorija, naziv)
values (6, 'region', 'Afrika');

insert into stavka_osiguranja (id, kategorija, naziv)
values (7, 'starosnaGrupa', 'Do 18 godina');
insert into stavka_osiguranja (id, kategorija, naziv)
values (8, 'starosnaGrupa', 'Izmedju 18 i 65 godina');
insert into stavka_osiguranja (id, kategorija, naziv)
values (9, 'starosnaGrupa', 'Preko 65 godina');

insert into stavka_osiguranja (id, kategorija, naziv)
values (10, 'iznosOsiguranja', '10.000 evra');
insert into stavka_osiguranja (id, kategorija, naziv)
values (11, 'iznosOsiguranja', '50.000 evra');
insert into stavka_osiguranja (id, kategorija, naziv)
values (12, 'iznosOsiguranja', '100.000 evra');


insert into cenovnik (id, datum_pocetka)
values (1, '20180601');

insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (1, 20, 'sport', 'Fudbal', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (2, 15, 'sport', 'Kosarka', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (3, 10, 'sport', 'Odbojka', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (4, 30, 'region', 'Evropa', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (5, 70, 'region', 'Azija', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (6, 50, 'region', 'Afrika', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (7, 5, 'starosnaGrupa', 'Do 18 godina', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (8, 10, 'starosnaGrupa', 'Izmedju 18 i 65 godina', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (9, 15, 'starosnaGrupa', 'Preko 65 godina', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (10, 15, 'iznosOsiguranja', '10.000 evra', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (11, 30, 'iznosOsiguranja', '50.000 evra', 1);
insert into stavka_cenovnika(id, cena, kategorija, naziv, cenovnik_id)
values (12, 60, 'iznosOsiguranja', '100.000 evra', 1);
