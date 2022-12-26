import React from 'react';
import { ConfigProvider, Button } from 'antd';

const App= React.FC = () => (
  <ConfigProvider
    theme={{
      token: {
        "colorPrimary": "#a78b6b",
        "colorInfo": "#fbe1c2",
        "colorError": "#ff797b",
        "colorSuccess": "#b3ff8c",
        "fontSize": 17,
        "borderRadius": 16,
        "wireframe": true
      },
    }}
  >
    <Button />
  </ConfigProvider>
);

export default App;