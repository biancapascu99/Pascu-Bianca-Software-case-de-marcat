# Software-case-de-marcat

## Entitati (modelele)
   * **Product** - _clasa abstracta care contine campurile name, price, quantity, discount_
        * **FoodProduct** - _clasa pentru produse alimentare care are in plus campul isExpired_
        * **CleaningProduct** - _clasa pentru produse de curatare care are in plus campul isExpired_
        * **AppliancesProduct** - _clasa pentru produse electrocasnice care are in plus hasGuarantee si priceTransport_
        * **FurnitureProduct** - _clasa pentru produse de mobilier care are in plus hasGuarantee si priceTransport_
        * **ClotheProduct** - _clasa pentru produse vestimentare care are in plus hasGuarantee si priceTransport_
   * **CashRegister** - _clasa care contine campurile cashierName si cashierNumber_
   * **Card** - _clasa care contine campurile name, cardNumber_
   * **Payment** - _clasa care contine campurile paymentId, productList, isFidelityCard, cashRegister, card, paymentCount_
   
## Actiuni (serviciile)
  * **ProductService** - _contine metodele changePriceOfProduct,  getProducts, addProduct, getExpired, getTransported, getGuarantee, deleteByName, findByName_
  * **CashRegisterService** - _contine metodele addCashRegister, changeNumberOfCashRegister, getCashRegister, deleteByNumber, findByNumber_
  * **CardService** - _contine metodele addCard, getCard_
  * **PaymentService** - _contine metodele addPayment, getPayments, getByCashRegister, getByPaymentCard, getByPaymentCash, deleteById, findById_
  
 _Fiecare serviciu are o singura instanta in timpul rularii, iar implementarea efectiva a operatiilor se face in clasele repository corespunzatoare._
