import React, { FC, ReactElement } from "react";
import { Button, Card, Col, Form, FormInstance, Input, Rate, Row, Typography } from "antd";
import { SendOutlined } from "@ant-design/icons";

import { ReviewResponse, ReviewError } from "../../../types/types";
import ReviewItem from "./ReviewItem/ReviewItem";
import { ReviewData } from "../Product";
import "./ProductReviews.css";

type PropType = {
    reviews: ReviewResponse[];
    reviewErrors: Partial<ReviewError>;
    addReview: (data: ReviewData) => void;
    form?: FormInstance<any>;
};

const ProductReviews: FC<PropType> = ({ reviews, reviewErrors, addReview, form }): ReactElement => {
    const { authorError, messageError, ratingError } = reviewErrors;

    return (
        <>
            
            
        </>
    );
};

export default ProductReviews;
