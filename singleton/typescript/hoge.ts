import Singleton from './Singleton';
export default () => {
  console.log('hogeの実行が開始されました');
  const instance = Singleton;
  const members = instance.getMembers();
  console.log(members[0]);
  console.log(members[1]);
};

