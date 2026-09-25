# Daily Quiz & Challenge — Native Android UI/UX Blueprint

## 1. Purpose

This document is the native Android UI/UX companion to `native-android-roadmap.md`.

It translates the V1 UI/UX lessons and the existing V1 design blueprint into requirements for the V2 native Android educational platform.

V1 React/Vite/Capacitor remains the stabilized reference product. Its UI should inform us about what worked and what needs improvement, but V2 must be designed as a genuinely native Android experience rather than a visual copy of V1.

## 2. Product Experience Vision

The product is an **educational platform**, not only a quiz app.

The experience should combine:
- Quiz and challenge experiences.
- Learning-oriented content.
- Bible reading and future study tools.
- Progress and statistics.
- Current Affairs and other dynamic educational content.
- Future educational sections without redesigning the application shell.

Core feeling: **Clean Competitive**.

Target qualities:
- Clean
- Modern
- Premium
- Energetic
- Competitive
- Professional
- Playful without being childish
- Sharp and easy to understand
- Accessible
- Consistent

Avoid:
- Excessive gradients
- Visual clutter
- Generic/basic layouts
- Overly corporate styling
- Overly childish game styling
- Unnecessary decoration
- Every screen having a different visual language

Create an original Richard Studios / Daily Quiz & Challenge identity. External UI references are research and inspiration, not templates to copy.

## 3. Native Android UI Foundation

The UI will be implemented with Kotlin + Jetpack Compose and a reusable design system.

The design system should define:
- Typography
- Color roles
- Spacing scale
- Shapes/corner radius
- Elevation/shadow rules
- Buttons
- Cards
- Inputs
- Dialogs
- Feedback components
- Navigation
- Loading/error/empty states
- Ad containers
- Accessibility behavior

Material 3 can provide primitives, but the final product must have its own visual identity.

## 4. Typography and Text Behavior

Typography must be:
- Modern
- Highly readable
- Strong for headings
- Clear for questions
- Comfortable on small screens
- Consistent across the platform

Hierarchy should distinguish:
1. Screen titles
2. Scores/major numbers
3. Quiz questions
4. Section headings
5. Body text
6. Secondary/helper text
7. Button labels
8. Status/metadata

### V2 copy/selection requirement

Ordinary learner-facing interface and quiz text should **not be casually selectable/copyable**.

Question text, answer options, category labels, buttons, explanations and result text should use native Compose rendering without unnecessary text-selection behavior.

This is a practical anti-copy requirement, not an assertion that screenshots, OCR, accessibility tooling, debugging or other extraction methods can be absolutely prevented.

Accessibility must not be damaged merely to discourage copying. Final implementation should balance non-selectable presentation with appropriate Android accessibility semantics.

## 5. Visual Direction

Initial palette direction from V1 planning:
- Near-white background
- Strong primary blue
- Deep blue/navy for hierarchy
- Dark readable text
- Muted secondary text
- White cards
- Green for success
- Red for incorrect/error
- Warm amber/gold as a restrained accent for points, streaks and rewards

The final palette must be visually tested and accessibility-checked.

Never rely on color alone:
- Correct = color + check/label
- Incorrect = color + X/label

Touch targets must be comfortable for mobile use.

## 6. Responsive and Adaptive Layout

Design for:
- Android phones, including the original V1 test-device class
- Larger phones
- Landscape
- Tablets
- Foldables
- Split-screen and changing window sizes

Do not hard-code a phone-only layout.

## 7. Platform Navigation

The application should use a small primary navigation structure, approximately 4–5 destinations initially, while leaving room for future sections.

Conceptual destinations:
- **Home** — daily activity, recommendations, progress and entry points.
- **Learn / Quiz** — quiz and learning experiences.
- **Bible** — dedicated Bible reading/library/study experience.
- **Explore / Library** — future educational resources.
- **Profile / Progress** — progress, statistics, settings and future account capabilities.

These are architectural concepts, not a final visual navigation decision.

Navigation requirements:
- Clear top-level destinations.
- Nested navigation inside major sections.
- Predictable Android back/up behavior.
- Independent navigation history where appropriate.
- Bible hierarchy without making every Bible function a top-level destination.
- Future features should be added without rewriting the application shell.

## 8. Home Experience

The home screen becomes the platform entry point rather than a simple grid of category cards.

Possible hierarchy:
1. Greeting
2. Daily Challenge
3. Streak/progress
4. Continue learning/playing
5. Explore categories or educational sections
6. Additional features
7. Primary navigation

The exact content should be finalized during wireframing.

## 9. Educational Sections

Initial quiz/learning areas include:
- General Knowledge
- Science
- Africa & Nigeria
- Current Affairs
- Bible

Bible is not merely a category card. It opens a dedicated product experience.

Future categories and educational modules must fit the same design system.

Current Affairs should distinguish structured Current Affairs knowledge from a future News Quiz / Current Events experience. NewsData.io or another news provider belongs to that future news product and should not define the Current Affairs UI.

## 10. Quiz Experience

The quiz screen remains a major experience within the larger platform.

Target structure:
- Appropriate back/navigation control
- Question number
- Progress
- Timer
- Question
- Four answer options
- Streak/progress indicator
- Clear feedback

V1 uses a 15-second question timer. Native redesign should preserve the validated gameplay rule unless separately changed and tested.

Answer states:
1. Default
2. Pressed
3. Selected
4. Correct
5. Incorrect
6. Disabled/locked

Feedback must be immediate, readable and accessible.

## 11. Quiz Content UX

The UI must never assume that questions come from one API.

The client should consume validated question objects supplied by the content/backend architecture.

The UI should support metadata needed for:
- Question identity
- Difficulty
- Provenance when user-facing attribution is appropriate
- Explanations when available
- Freshness/status where useful

Source/attribution information must not clutter the quiz screen.

If questions cannot be loaded:
- Explain the problem in plain language.
- Offer retry where appropriate.
- Do not expose raw API/provider errors.

## 12. Results and Progress

Results should feel useful and satisfying.

Show where appropriate:
- Completion
- Score
- Accuracy
- Points earned
- Correct/wrong counts
- Streak
- Progress
- Next actions

Future learning enhancements:
- Explanations
- Learning feedback
- Topic performance
- Personalized recommendations
- Achievements

Progress should eventually connect to account/cloud architecture when that is implemented.

## 13. Bible UX

Bible is a major platform section.

Conceptual information architecture:

```
Bible
├── Read Bible
│   ├── Testament
│   ├── Book
│   ├── Chapter
│   └── Reader
├── Bible Quiz
│   ├── Quick Quiz
│   ├── Book Quiz
│   ├── Chapter Quiz
│   └── Topic Quiz
└── Future Study Tools
```

Future Bible reader requirements:
- Offline reading where licensing permits.
- Book/chapter navigation.
- Search.
- Silent reading by default.
- User-triggered read-aloud.
- Play/pause/resume/stop controls.
- Future speed/voice controls.

Voice reading must never start automatically when a chapter opens.

V1 may retain a simple “Bible — Coming Soon” placeholder until the native experience is ready.

## 14. Loading, Error and Connectivity UX

Connectivity is a first-class state.

Design for:
- Loading
- Connecting
- Offline
- Connection lost
- Requesting
- Provider/API delay
- Empty result
- Temporary provider failure
- Retry
- Quiz unavailable
- Ad unavailable
- Unexpected error

Messages must be short, clear, non-technical and actionable.

Example:
> **Internet connection required**
> Connect to the internet to start a quiz.

Bible offline reading should not be incorrectly blocked merely because quiz functionality requires internet.

## 15. Ads UX

V1 AdMob behavior is a stabilized capability and must be preserved during native redesign.

Ad principles:
- Ads should feel integrated, not accidental.
- Never cover quiz content or controls.
- Do not make the core quiz inaccessible because an ad failed.
- Use natural transitions for interstitials.
- Rewarded ads must be explicitly optional.
- Preserve tested banner/rewarded/interstitial behavior while adapting it to native Android.

Potential placements:
- Appropriate persistent banner areas
- Natural transition points
- Quiz completion
- Optional rewarded action

Development uses test ads; production uses production configuration.

## 16. Premium/Billing UX

The UI must be designed to support future centralized commercial entitlements without embedding billing decisions into individual screens.

Future surfaces may include:
- Premium/store landing screen
- Monthly/yearly subscription options
- Remove Ads
- Premium content packs
- Product detail/benefit view
- Purchase confirmation
- Restore/synchronize purchases
- Active Premium status
- Pending/error/expired states

Principles:
- Show value before asking for payment.
- Make price and billing period clear.
- Distinguish subscription from one-time purchase.
- Keep the free experience useful.
- Avoid deceptive urgency or aggressive paywalls.
- Clearly communicate entitlements.
- Preserve the user's place when returning from a purchase flow.

Google Play purchase UI should hand off to the supported Google Play purchase experience rather than collecting payment card details directly in the app.

Billing UI is planned, not an initial implementation requirement.

## 17. Reusable Components

Initial component library:
- Primary/secondary buttons
- Category cards
- Daily Challenge card
- Answer options
- Progress indicators
- Timer
- Score display
- Streak indicator
- Achievement badge
- Dialogs
- Snackbar/toast
- Navigation components
- Loading indicators
- Error/empty states
- Ad containers
- Premium/entitlement indicators

Each component should have documented size, spacing, typography, shape, elevation, color and interaction states.

## 18. Animation and Motion

Motion should:
- Confirm interactions.
- Clarify transitions.
- Reinforce feedback.
- Celebrate meaningful achievements.
- Communicate loading/progress.

Avoid excessive animation during timed quizzes.

Animations must remain performant on lower-end Android devices.

## 19. Accessibility

Requirements:
- Sufficient contrast.
- Do not rely on color alone.
- Meaningful content descriptions where appropriate.
- Comfortable touch targets.
- Scalable text/layout behavior.
- Logical focus/navigation semantics.
- Accessibility testing during implementation.

Copy protection must not be implemented in a way that makes the product inaccessible.

## 20. UI/UX Implementation Process

Use:

**RESEARCH → WIREFRAME → DESIGN SYSTEM → HIGH-FIDELITY SCREENS → IMPLEMENT → BUILD → INSTALL → TEST → FIX → CHECKPOINT**

Do not redesign production V1 while V2 is being planned.

Do not implement every future screen before the underlying architecture is ready.

## 21. Relationship to Native Android Roadmap

This document provides the detailed UX requirements for the roadmap stages.

`native-android-roadmap.md` remains the master V2 project roadmap.

UI/UX must stay aligned with:
- Multi-source content architecture
- Question identity/history/repetition rules
- Bible architecture
- Network behavior
- Commercial entitlement architecture
- Native Android architecture
- Future educational sections

A UI decision must not force provider-specific or billing-specific logic into the Android presentation layer.

## 22. Current Status — September 25, 2026

- V1 UI remains the stabilized reference baseline.
- Major redesign is deferred from V1.
- Native Android is the target implementation.
- Educational-platform navigation is a V2 architectural requirement.
- Bible is a major product section.
- Native typography and controlled text selection/copy behavior are explicit V2 requirements.
- Quiz UI must consume a provider-independent question/content system.
- AdMob behavior must be preserved/regression-tested.
- Premium/billing UX is planned but not implemented.
- High-fidelity visual design and implementation begin only after the native foundation and content architecture are ready.
