import React, { useState } from 'react';
import './App.css';

function App() {
  const [prompt, setPrompt] = useState('');
  const [messages, setMessages] = useState([]);

  const handleSubmit = async () => {
    if (!prompt.trim()) return;

    const newMessages = [...messages, { role: 'user', content: prompt }];
    setMessages(newMessages);
    setPrompt('');

    try {
      const res = await fetch('http://localhost:8080/api/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ messages: newMessages })
      });

      const data = await res.text();
      setMessages([...newMessages, { role: 'assistant', content: data }]);
    } catch (error) {
      console.error("Error fetching:", error);
    }
  };

  return (
    <div className="App">
      <h1>Primo</h1>
      <div className="chat-window">
        {messages.map((msg, idx) => (
          <div key={idx} className={msg.role}>
            <strong>{msg.role}:</strong> {msg.content}
          </div>
        ))}
      </div>
      <input
        type="text"
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
        placeholder="Enter your message"
      />
      <button onClick={handleSubmit}>Send</button>

      <footer style={{ marginTop: '40px', color: '#aaa', fontSize: '14px' }}>
        Powered with <span style={{ color: 'red' }}>&hearts;</span> by Bhardwaj
      </footer>
    </div>
  );
}

export default App;
