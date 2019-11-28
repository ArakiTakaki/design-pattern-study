import Singleton from './Singleton';
import hoge from './hoge';

const instance = Singleton;

instance.addMember('やな');
instance.addMember('のざわ');
const members = instance.getMembers();

console.log(members[0]);
console.log(members[1]);

hoge();

