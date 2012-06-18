## Templates

### Introduction

The design is template agnostic. A number of common template engine are included by default, 
including:

1. Markdown (.md)
2. Apache Velocity (.vtl)
3. Moustache (in progress)

The templating engine is selected based on the file extension, e.g ".md" for markdown. Content can 
passed through multiple engines merely by specifying the multiple extensions. The file "```index.vtl.md```" 
would first be evaluated as a velocity template, and results then evaluated as markdown.   