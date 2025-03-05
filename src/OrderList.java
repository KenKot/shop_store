public class OrderList {
    private int numOrders;
    private Order[] orderArray;

    public OrderList() {
        this.numOrders = 0;
        this.orderArray = new Order[7];
    }

    public void add(Order order) {
        
        for (int i = 0; i < numOrders; ++i) {
            Order curr = orderArray[i];
            if (order.getId().equals(curr.getId())) {  
                return;
            }
        }
        
		if (this.numOrders >= orderArray.length) {
			Order[] newOrderArray = new Order[orderArray.length * 2];

			// Copy old array into new/bigger array
			for (int i = 0; i < orderArray.length; ++i) {
				newOrderArray[i] = orderArray[i];
			}

			orderArray = newOrderArray;
		}
        
        
        if (numOrders == 0) {
            orderArray[0] = order;
            ++numOrders;
            return;
        }
        
        for (int i = numOrders - 1; i >= 0; --i) {
            if (order.getId().compareTo(orderArray[i].getId()) >= 0) { 
                orderArray[i + 1] = order;
                ++numOrders;
                return;
            } else {
                orderArray[i + 1] = orderArray[i];
                if (i == 0) {
                    orderArray[0] = order;
                    ++numOrders;
                    return;
                }
            }
        }
    }

   	public boolean contains(Order order) {
   		for (int i = 0; i < numOrders; i++) {
   			if (orderArray[i].getId().equals(order.getId())) { 
   				return true; 
   			}
   		}
   		return false; 
   	}

   	
   public int size() {
        return numOrders;
    }

    public Order get(int index) {
        return orderArray[index];
    }
    public Order[] getOrders() {
    	return this.orderArray;
    }
}
