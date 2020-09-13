import {CREATE_USER_ENDPOINT} from './Endpoints';
import {makeUrl} from '../../config/Utility';
import axios from 'axios';

export default function registerUser(input) {
    return axios.post(makeUrl(CREATE_USER_ENDPOINT), {...input})
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
};
