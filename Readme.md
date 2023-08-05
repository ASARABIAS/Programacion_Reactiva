# Facturas
El siguiente proyecto consiste en replicar una parte de facturas. Expecificamente la consulta de las facturas incritas de un cliente, pero no es su totalidad para evitar la complejidad de data en esta actividad 

# Dominio
## Bill
Clase principal que nos muestra la info de una factura:
* id - Identificador unico
* name - Nombre del convenio de la factura
* agreement - Codigo del convenio de la factura
* endDate -  Fecha de corte
* amount - Monto a pagar
* description - Descripcion de la factura
* validationDataBase - Tipo de validación de Base de datos
* status - Estado de la factura
* reference - Referencia de pago
* bankAccount - Cuenta bancaria del Recaudador

## ValidationDataBase
Enumera los tipos de validaciones de base de Datos:
* key - Idenficador unico
* valor - Descripcion del identificador

## Status
Clase que determina el estado de la factura:
* enabledToPay - Si esta permitido el pago
* value - Valor del estado de la factura inscrita

## StatusValue
Enumera los tipos de estados que puede presentar una factura:
* key - Idenficador unico
* valor - Descripcion del identificador

## Reference
Clase que determina la referencia de pago:
* value - Valor de la referencia de pago
* name - Nombre de la referencia

## BankAccount
Clase que determina la Cuenta bancaria del Recaudador:
* acctId - Numero de la cuenta bancaria
* acctTypeCode - Codigo del tipo de Cuenta
* acctTypeCodeDesc - Descripcion del Codigo