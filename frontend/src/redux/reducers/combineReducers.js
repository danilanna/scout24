import {combineReducers} from 'redux';
import realEstateReducer from './realEstateReducer';

const rootReducer = combineReducers({
    realEstateReducer,
});

export default rootReducer;