import React, { FC, ReactElement } from "react";
import { useDispatch, useSelector } from "react-redux";
import { LoginOutlined, LogoutOutlined, ShoppingCartOutlined, UserAddOutlined, UserOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";
import { Affix, Badge, Col, Row, Space } from "antd";

import { selectUserFromUserState } from "../../redux-toolkit/user/user-selector";
import { selectCartItemsCount } from "../../redux-toolkit/cart/cart-selector";
import { logoutSuccess } from "../../redux-toolkit/user/user-slice";
import { ACCOUNT, BASE, CONTACTS, LOGIN, MENU, REGISTRATION } from "../../constants/routeConstants";
import { CART } from "../../constants/urlConstants";
import "./NavBar.scss";

const NavBar: FC = (): ReactElement => {
    const dispatch = useDispatch();
    const usersData = useSelector(selectUserFromUserState);
    const cartItemsCount = useSelector(selectCartItemsCount);

    const handleLogout = (): void => {
        localStorage.removeItem("token");
        dispatch(logoutSuccess());
    };

    return (
        <>
            <div className={"navbar-logo-wrapper"}>
                <img height={40} alt={"navbar-logo"} src="https://www.aromasartesanales.de/wp-content/uploads/2021/12/cropped-cropped-Aromas-Online.png" />
            </div>
            <Affix>
                <div className={"navbar-wrapper"}>
                    <Row>
                        <Col span={24} style={{textAlign:"center"}}>
                            <ul>
                                <li>
                                <Link to={BASE}>
                                    HOME
                                </Link>
                                </li>
                                <li>
                                    <Link to={{ pathname: MENU, state: { id: "all" } }}>PRODUCTS</Link>
                                </li>
                             
                                <li className={"navbar-cart"}>
                                    <Badge count={cartItemsCount} size="small" color={"green"}>
                                        <Link to={CART}>
                                            <ShoppingCartOutlined />
                                        </Link>
                                    </Badge>
                                </li>
                                {usersData ? (
                                    <>  <li>
                                        <Link to={ACCOUNT}>
                                            
                                                <UserOutlined />
                                                MY ACCOUNT
                                            
                                        </Link></li><li>
                                        <Link id={"handleLogout"} to={BASE} onClick={handleLogout}>
                                            
                                                <LogoutOutlined />
                                                EXIT
                                            
                                        </Link></li>
                                    </>
                                ) : (
                                    <><li>
                                        <Link to={LOGIN}>
                                            
                                                <Space align={"baseline"}>
                                                    <LoginOutlined />
                                                    SIGN IN
                                                </Space>
                                            
                                        </Link></li><li>
                                        <Link to={REGISTRATION}>
                                            
                                                <UserAddOutlined />
                                                SIGN UP
                                            
                                        </Link></li>
                                    </>
                                )}
                            </ul>
                        </Col>
                    </Row>
                </div>
            </Affix>
        </>
    );
};

export default NavBar;
