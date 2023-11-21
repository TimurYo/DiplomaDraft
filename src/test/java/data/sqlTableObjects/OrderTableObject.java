package data.sqlTableObjects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderTableObject {
    String id;
    String created;
    String creditId;
    String paymentId;
}
