package data.sqlTableObjects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditTableObject {
    String id;
    String bankId;
    String created;
    String status;
}
