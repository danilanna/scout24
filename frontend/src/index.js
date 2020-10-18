import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {Provider} from 'react-redux';
import './index.css';
import * as serviceWorker from './serviceWorker';
import configureStore from "./redux/store/configureStore";
import RealEstateList from './components/real-estate/RealEstateList';
import RealEstate from "./components/real-estate/ReaEstate";

const store = configureStore()

ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <Router>
                <Switch>
                    <Route exact path="/">
                        <RealEstateList/>
                    </Route>
                    <Route exact path="/new">
                        <RealEstate/>
                    </Route>
                </Switch>
            </Router>
        </Provider>
    </React.StrictMode>,
    document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();