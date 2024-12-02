SELECT 
    tc.tipo AS tipo_cliente,
    DATE_FORMAT(t.fecha, '%Y-%m') AS mes,
    SUM(t.comision) AS total_comisiones
FROM transaccion t
JOIN cuenta_bancaria cb ON t.cuenta_asociada = cb.id_cuenta
JOIN cliente c ON cb.id_cliente = c.id_cliente
JOIN tipo_cliente tc ON c.id_tipo_cliente = tc.id_tipo_cliente
WHERE t.tipo = 'Transferencia'
GROUP BY tc.tipo, DATE_FORMAT(t.fecha, '%Y-%m')
ORDER BY mes, tipo_cliente;
