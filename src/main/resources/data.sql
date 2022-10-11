DELETE FROM IPTUDebito;

INSERT INTO IPTUDebito
    (id, imposto, matricula, ano, codigodebarras, vloriginal, parcela, vltotal, dtvenc)
VALUES
    (1, '15%', 123321, 2022, '678876678', 350000, 1, 400000, '22-10-2022');