public class KenListPayment {
    private int numPayments;
    private Payment[] paymentArray;

    public KenListPayment() {
        this.numPayments = 0;
        this.paymentArray = new Payment[1];
    }

    public void addPayment(Payment payment) {
        
        for (int i = 0; i < numPayments; ++i) {
            Payment curr = paymentArray[i];
            if (payment.getId().equals(curr.getId())) {  // Fixed string comparison
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
            if (payment.getId().compareTo(paymentArray[i].getId()) >= 0) {  // Fixed string comparison for sorting
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

    
    public Payment[] getPayments() {
    	return this.paymentArray;
    }
}
