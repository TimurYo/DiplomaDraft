package data.sqlTableObjects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentTableObject {
    public String id;
    public String amount;
    public String created;
    public String status;
    public String transaction_id;
}
