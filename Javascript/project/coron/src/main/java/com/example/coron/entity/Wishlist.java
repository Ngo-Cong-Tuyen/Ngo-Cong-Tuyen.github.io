package com.example.coron.entity;

import com.example.coron.dto.WishlistInfo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedNativeQuery(
        name = "getWishlistInfo",
        query = "select p.sku , i.url as image , p.name as productName , p.price , (select if ((select sum(quantity) from amount a \n" +
                "where a.product_id  = p.id)>0,1,0))as stockStatus  from wishlist w \n" +
                "inner join product p ON p.id = w.product_id \n" +
                "left  join image i on i.product_id = p.id \n" +
                "inner join `user` u on w.user_id = u.id \n" +
                "where u.email = ?1 and w.status =1 \n" +
                "group by w.id ",
        resultSetMapping = "wishlistInfo"
)
@SqlResultSetMapping(
        name = "wishlistInfo",
        classes = @ConstructorResult(
                targetClass = WishlistInfo.class,
                columns = {
                        @ColumnResult(name = "sku" ,type = String.class),
                        @ColumnResult(name = "image" ,type = String.class),
                        @ColumnResult(name = "productName" ,type = String.class),
                        @ColumnResult(name = "price" ,type = Integer.class),
                        @ColumnResult(name = "stockStatus" ,type = Integer.class)
                }
        )
)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "status")
    private Integer status;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}