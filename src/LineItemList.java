public class LineItemList {
    private int numLineItems;
    private LineItem[] lineItemArray;

    public LineItemList() {
        this.numLineItems = 0;
        this.lineItemArray = new LineItem[7];
    }

    public void add(LineItem lineItem) {
        
        for (int i = 0; i < numLineItems; ++i) {
            LineItem curr = lineItemArray[i];
            if (lineItem.getId().equals(curr.getId())) {  
                return;
            }
        }
        
		if (this.numLineItems >= lineItemArray.length) {
			LineItem[] newLineItemArray = new LineItem[lineItemArray.length * 2];

			// Copy old array into new/bigger array
			for (int i = 0; i < lineItemArray.length; ++i) {
				newLineItemArray[i] = lineItemArray[i];
			}

			lineItemArray = newLineItemArray;
		}
        
        
        if (numLineItems == 0) {
            lineItemArray[0] = lineItem;
            ++numLineItems;
            return;
        }
        
        for (int i = numLineItems - 1; i >= 0; --i) {
            if (lineItem.getId().compareTo(lineItemArray[i].getId()) >= 0) { 
                lineItemArray[i + 1] = lineItem;
                ++numLineItems;
                return;
            } else {
                lineItemArray[i + 1] = lineItemArray[i];
                if (i == 0) {
                    lineItemArray[0] = lineItem;
                    ++numLineItems;
                    return;
                }
            }
        }
    }
   public int size() {
        return numLineItems;
    }

    public LineItem get(int index) {
        return lineItemArray[index];
    }
    
    public LineItem[] getLineItems() {
    	return this.lineItemArray;
    }
}
