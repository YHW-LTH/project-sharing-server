package YHWLTH.sharing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "SHARINGITEM_SEQ_GENERATOR",
        sequenceName = "SHARINGITEM_SEQ",
        allocationSize = 1
)
public class SharingItem {

    @Id
    @Column(name = "sharingItem_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHARINGITEM_SEQ_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "shareItem_id")
    private ShareItem shareItem;

    private LocalDate startDate;
    private LocalDate endDate;
    private Long deposit;

    public SharingItem(ShareApply shareApply, User user, ShareItem shareItem) {
        this.user = user;
        this.shareItem = shareItem;
        this.startDate = LocalDate.now();
        this.endDate = shareApply.getEndDate();
        this.deposit = shareItem.getDeposit();
    }
}