package com.example.coron.entity;

import com.example.coron.dto.CartInfo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedNativeQuery(
        name = "getAllCartInfoByUserId",
        query =
                "select c.user_id , c.id as cart_id, p.name as product_name, p.sku, p.price, c.quantity ,i.url as image, c.updated_at  from cart c\n" +
                        "                        inner join amount a on a.id = c.amount_id \n" +
                        "                        inner join product p on a.product_id = p.id\n" +
                        "                        inner join image i on i.product_id = p.id\n" +
                        "                        inner join `user` u on u.id = c.user_id \n" +
                        "                        where c.user_id= ?1 and (c.status is null or c.status =0) \n" +
                        "                        group by c.id",
        resultSetMapping = "listCartInfo"
)
@SqlResultSetMapping(
        name = "listCartInfo",
        classes = @ConstructorResult(
                targetClass = CartInfo.class,
                columns = {
                        @ColumnResult(name = "user_id", type = Integer.class),
                        @ColumnResult(name = "cart_id", type = Integer.class),
                        @ColumnResult(name = "product_name" ,type = String.class),
                        @ColumnResult(name = "sku" ,type = String.class),
                        @ColumnResult(name = "price",type = Integer.class),
                        @ColumnResult(name = "quantity",type = Integer.class),
                        @ColumnResult(name = "image",type = String.class),
                        @ColumnResult(name = "updated_at",type = LocalDateTime.class)
                }
        )
)

@NamedNativeQuery(
        name = "getAllNewCartInfo",
        query =
                "select c.user_id , c.id as cart_id, p.name as product_name, p.sku, p.price, c.quantity ,i.url as image, c.updated_at  from cart c\n" +
                        "                        inner join amount a on a.id = c.amount_id \n" +
                        "                        inner join product p on a.product_id = p.id\n" +
                        "                        inner join image i on i.product_id = p.id\n" +
                        "                        inner join `user` u on u.id = c.user_id \n" +
                        "                        where  (c.status =1) \n" +
                        "                        group by c.id",
        resultSetMapping = "listCartInfo"
)


@NamedNativeQuery(
        name = "getAllCartOrder",
        query =
                "select c.user_id , c.id as cart_id, p.name as product_name, p.sku, p.price, c.quantity ,i.url as image, c.updated_at  from cart c\n" +
                        "                        inner join amount a on a.id = c.amount_id \n" +
                        "                        inner join product p on a.product_id = p.id\n" +
                        "                        inner join image i on i.product_id = p.id\n" +
                        "                        inner join `user` u on u.id = c.user_id \n" +
                        "                        where  (c.order_id =?1) \n" +
                        "                        group by c.id",
        resultSetMapping = "listCartInfo"
)


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "amount_id")
    private Amount amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private Integer status=0;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}