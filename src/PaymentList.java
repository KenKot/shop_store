public class PaymentList {
    private int numPayments;
    private Payment[] paymentArray;

    public PaymentList() {
        this.numPayments = 0;
        this.paymentArray = new Payment[7];
    }

    public void add(Payment payment) {
        
        for (int i = 0; i < numPayments; ++i) {
            Payment curr = paymentArray[i];
            if (payment.getId().equals(curr.getId())) {  
                return;
            }
        }
        
		if (this.numPayments >= paymentArray.length) {
			Payment[] newPaymentArray = new Payment[paymentArray.length * 2];

			// Copy old array into new/bigger array
			for (int i = 0; i < paymentArray.length; ++i) {
				newPaymentArray[i] = paymentArray[i];
			}

			paymentArray = newPaymentArray;
		}
        
        
        if (numPayments == 0) {
            paymentArray[0] = payment;
            ++numPayments;
            return;
        }
        
        for (int i = numPayments - 1; i >= 0; --i) {
            if (payment.getId().compareTo(paymentArray[i].getId()) >= 0) { 
                paymentArray[i + 1] = payment;
                ++numPayments;
                return;
            } else {
                paymentArray[i + 1] = paymentArray[i];
                if (i == 0) {
                    paymentArray[0] = payment;
                    ++numPayments;
                    return;
                }
            }
        }
    }

   public int size() {
        return numPayments;
    }

    public Payment get(int index) {
        return paymentArray[index];
    }
    
    public Payment[] getPayments() {
    	return this.paymentArray;
    }
}
