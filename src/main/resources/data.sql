DELETE FROM IPTUDebito;

INSERT INTO IPTUDebito
    (id, imposto, matricula, ano, codigodebarras, vloriginal, parcela)
VALUES
    (1, '15%', 123321, 2022, '678876678', 350000, 1);