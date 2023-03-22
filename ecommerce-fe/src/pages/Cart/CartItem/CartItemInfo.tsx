import React, { FC, memo, ReactElement } from "react";
import { Col, Typography } from "antd";

import { PerfumeResponse } from "../../../types/types";

type PropsType = {
    perfume: PerfumeResponse;
};

const CartItemInfo: FC<PropsType> = memo(({ perfume }): ReactElement => {

    return (
        <>
            <Col span={8} className={"cart-item-image"}>
                <img src={perfume.filename} alt={perfume.productTitle} style={{ height: 100 }} />
            </Col>
            <Col span={8}>
                <Typography.Title level={3}>{perfume.productr}</Typography.Title>
                <Typography.Title level={5}>{perfume.productTitle}</Typography.Title>
                <Typography.Text strong>{perfume.volume} ml.</Typography.Text>
            </Col>
        </>
    );
});

export default CartItemInfo;
