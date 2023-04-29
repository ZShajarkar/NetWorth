package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "assets")
public class Asset {
    private BigDecimal realState;
    private BigDecimal checkingAccounts;
    private BigDecimal savingAccounts;
    private BigDecimal retirementAccounts;
    private BigDecimal cars;
    private BigDecimal otherAssets;
    @Id
    private Long id;
}
